# item-forge dashboard

An optional web app for managing item-forge content. It has forms for items, armor, recipes, and
blocks, a browser-based texture editor, and a page for viewing the balance report.

The dashboard connects to the plugin's HTTP API. It is not needed to use the plugin in game.

## Run with Java

1. Start the plugin on a Paper server and enable `dashboard-api` in
   `plugins/item-forge/config.yml`. Set `dashboard-api.api-key` to a private token.
2. Build the dashboard:

   ```bash
   cd dashboard
   mvn clean package -Prelease -DskipTests
   ```

3. Set the environment variables and run the jar. Use the same API token in the plugin and
   dashboard:

   ```bash
   ITEM_FORGE_API_BASE_URL=http://localhost:8081 \
   ITEM_FORGE_API_TOKEN='your-private-token' \
   DASHBOARD_ADMIN_USERNAME=admin \
   DASHBOARD_ADMIN_PASSWORD_HASH='your-bcrypt-password-hash' \
   java -jar target/item-forge-dashboard-*.jar
   ```

   The dashboard is available at `http://localhost:8090`.

Create a token with `openssl rand -hex 32`. To create a BCrypt password hash, use
`htpasswd -inBC 10 "" <<< 'your-password' | tr -d ':\n'` (from `httpd-tools` on Fedora).

## Features

- Create and edit items, armor, recipes, and blocks.
- Draw and save textures in the Texture Studio.
- Import a resource pack you have into a local texture reference library.
- View the plugin's balance report.

The texture reference library stays on the machine running the dashboard. The app does not
include or download Minecraft assets.

## Docker

From the project root, `./install.sh` can configure and start the Paper server and dashboard
using Docker Compose. Docker and Docker Compose are required. The installer sets up the API
connection and persistent dashboard data.

If you expose the dashboard to other machines, keep it on a trusted network or place it behind
an HTTPS reverse proxy. Use private API and admin credentials.
