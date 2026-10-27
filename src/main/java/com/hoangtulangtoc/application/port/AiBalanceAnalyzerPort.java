package com.hoangtulangtoc.application.port;

import java.util.List;

import com.hoangtulangtoc.domain.balance.BalanceAnalysisRequest;
import com.hoangtulangtoc.domain.balance.BalanceFinding;
import com.hoangtulangtoc.domain.balance.BalanceReport;

/**
 * Asks an AI provider for the judgement calls the rules cannot make -- whether a set of items
 * fits together, whether a theme is coherent, whether a number is right for this server.
 */
public interface AiBalanceAnalyzerPort {

    /**
     * @param ruleFindings what the deterministic rules already found, passed along as context so
     *        the model comments on the real numbers instead of re-deriving them and repeats less
     * @return findings the rules did not produce, plus a narrative summary
     * @throws com.hoangtulangtoc.application.exception.AiBalanceAnalysisException if the
     *         provider call fails
     */
    BalanceReport analyze(BalanceAnalysisRequest request, List<BalanceFinding> ruleFindings);
}
