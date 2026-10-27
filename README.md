# item-forge

A personal Paper plugin project for creating custom Minecraft items, armor, recipes, and blocks
from YAML files. It builds a resource pack and serves it to players from the server.

![Using a custom item ability](screenshots/ingame-ability.gif)

[Screenshots and GIFs](screenshots/README.md)

## What it includes

- Custom items, armor, crafting recipes, and blocks.
- Resource pack generation and hosting.
- Click abilities with cooldowns.
- `/item-forge` commands to list, give, reload, and check configured content.
- Optional AI item generation and a web dashboard.

## Requirements

- Paper 1.20.5 or newer
- Java 21 or newer

## Build and install

Build the plugin from the project folder:

```bash
mvn clean package
```

Copy `target/item-forge-1.0.0-SNAPSHOT.jar` to your Paper server's `plugins/` folder and start
the server. The plugin creates its configuration files in `plugins/item-forge/`.

Set `resource-pack.host` in `config.yml` to an address that players can reach, then restart the
server. To use the included sample textures, copy them into the plugin's texture folder:

```bash
cp -r examples/textures/. /path/to/server/plugins/item-forge/textures/
```

See [examples/textures](examples/textures/README.md) for the sample files. After editing the
content YAML files or copying textures, run `/item-forge reload` in game or from the server
console to rebuild the resource pack.

## Configuration

The plugin creates these files under `plugins/item-forge/`:

| File | Contents |
| --- | --- |
| `config.yml` | Resource pack hosting, cooldown display, and optional services. |
| `items.yml` | Custom items and their abilities. |
| `armor.yml` | Custom armor pieces. |
| `recipes.yml` | Crafting recipes. |
| `blocks.yml` | Custom blocks. |
| `textures/` | Item, armor, and block textures. |

AI generation is off by default. To use it, enable it in `config.yml` and add your own provider
API key. AI requests may incur charges. The `/item-forge analyze` command works without AI.

## Commands

| Command | What it does |
| --- | --- |
| `/item-forge list` | Show configured items, armor, recipes, and blocks. |
| `/item-forge give <id>` | Give yourself a configured item, armor piece, or block. |
| `/item-forge reload` | Reload content files and rebuild the resource pack. |
| `/item-forge analyze [id]` | Check the configured content for balance issues. |
| `/item-forge generate <id> <description>` | Create an item definition with the configured AI provider. |

The `analyze` command uses built-in checks; enabling AI adds an optional review. The `generate`
command requires AI to be enabled and configured.

## Optional dashboard

The dashboard provides browser forms for editing content, a texture editor, and the same balance
report. It runs as a separate application and requires `dashboard-api` to be enabled in the
plugin configuration. See [dashboard/README.md](dashboard/README.md) for setup.

## Optional Docker setup

The installer can set up a Paper server and dashboard with Docker Compose:

```bash
mvn clean package
./install.sh
```

Docker and Docker Compose are required. The installer asks for the server settings and starts
the containers.
