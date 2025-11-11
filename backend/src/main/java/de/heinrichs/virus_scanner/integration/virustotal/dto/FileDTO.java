package de.heinrichs.virus_scanner.integration.virustotal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * DTO Class generated based on <a href="https://docs.virustotal.com/reference/files">...</a> using ChatGPT and Lombok
 * (I am not writing all that boilerplate code myself, not happening lol)
 */
@Data
public class FileDTO {

    private DataDTO data;

    @Data
    public static class DataDTO {
        private String id;

        private String type;

        private Links links;

        private Attributes attributes;
    }

    @Data
    public static class Links {
        private String self;
    }

    @Data
    public static class Attributes {
        @JsonProperty("capabilities_tags")
        private List<String> capabilitiesTags;

        @JsonProperty("creation_date")
        private Long creationDate;

        @JsonProperty("crowdsourced_ids_results")
        private List<CrowdsourcedIdsResult> crowdsourcedIdsResults;

        @JsonProperty("crowdsourced_ids_stats")
        private CrowdsourcedIdsStats crowdsourcedIdsStats;

        @JsonProperty("crowdsourced_yara_results")
        private List<CrowdsourcedYaraResult> crowdsourcedYaraResults;

        private Boolean downloadable;

        @JsonProperty("first_submission_date")
        private Long firstSubmissionDate;

        @JsonProperty("last_analysis_date")
        private Long lastAnalysisDate;

        @JsonProperty("last_analysis_results")
        private Map<String, LastAnalysisResult> lastAnalysisResults;

        @JsonProperty("last_analysis_stats")
        private LastAnalysisStats lastAnalysisStats;

        @JsonProperty("last_modification_date")
        private Long lastModificationDate;

        @JsonProperty("last_submission_date")
        private Long lastSubmissionDate;

        private String md5;

        private String meaningfulName;

        private List<String> names;

        private String permhash;

        private Integer reputation;

        @JsonProperty("sandbox_verdicts")
        private Map<String, SandboxVerdict> sandboxVerdicts;

        private String sha1;

        private String sha256;

        @JsonProperty("sigma_analysis_results")
        private List<SigmaAnalysisResult> sigmaAnalysisResults;

        @JsonProperty("sigma_analysis_stats")
        private SigmaAnalysisStats sigmaAnalysisStats;

        @JsonProperty("sigma_analysis_summary")
        private Map<String, SigmaAnalysisSummary> sigmaAnalysisSummary;

        private Long size;

        private List<String> tags;

        @JsonProperty("times_submitted")
        private Integer timesSubmitted;

        private String tlsh;

        @JsonProperty("total_votes")
        private TotalVotes totalVotes;

        @JsonProperty("type_description")
        private String typeDescription;

        @JsonProperty("type_extension")
        private String typeExtension;

        @JsonProperty("type_tag")
        private String typeTag;

        @JsonProperty("unique_sources")
        private Integer uniqueSources;

        private String vhash;
    }

    @Data
    public static class CrowdsourcedIdsResult {
        @JsonProperty("alert_context")
        private List<AlertContext> alertContext;

        @JsonProperty("alert_severity")
        private String alertSeverity;

        @JsonProperty("rule_category")
        private String ruleCategory;

        @JsonProperty("rule_id")
        private String ruleId;

        @JsonProperty("rule_msg")
        private String ruleMsg;

        @JsonProperty("rule_source")
        private String ruleSource;
    }

    @Data
    public static class AlertContext {
        @JsonProperty("dest_ip")
        private String destIp;

        @JsonProperty("dest_port")
        private Integer destPort;

        private String hostname;

        private String protocol;

        @JsonProperty("src_ip")
        private String srcIp;

        @JsonProperty("src_port")
        private Integer srcPort;

        private String url;
    }

    @Data
    public static class CrowdsourcedIdsStats {
        private Integer info;

        private Integer high;

        private Integer low;

        private Integer medium;
    }

    @Data
    public static class CrowdsourcedYaraResult {
        private String description;

        @JsonProperty("match_in_subfile")
        private Boolean matchInSubfile;

        @JsonProperty("rule_name")
        private String ruleName;

        @JsonProperty("ruleset_id")
        private String rulesetId;

        @JsonProperty("ruleset_name")
        private String rulesetName;

        private String source;
    }

    @Data
    public static class LastAnalysisResult {
        private String category;

        @JsonProperty("engine_name")
        private String engineName;

        @JsonProperty("engine_update")
        private String engineUpdate;

        @JsonProperty("engine_version")
        private String engineVersion;

        private String method;

        private String result;
    }

    @Data
    public static class LastAnalysisStats {
        @JsonProperty("confirmed-timeout")
        private Integer confirmedTimeout;

        private Integer failure;

        private Integer harmless;

        private Integer malicious;

        private Integer suspicious;

        private Integer timeout;

        @JsonProperty("type-unsupported")
        private Integer typeUnsupported;

        private Integer undetected;
    }

    @Data
    public static class SandboxVerdict {
        private String category;

        private Integer confidence;

        @JsonProperty("malware_classification")
        private List<String> malwareClassification;

        @JsonProperty("malware_names")
        private List<String> malwareNames;

        @JsonProperty("sandbox_name")
        private String sandboxName;
    }

    @Data
    public static class SigmaAnalysisResult {
        @JsonProperty("rule_title")
        private String ruleTitle;

        @JsonProperty("rule_source")
        private String ruleSource;

        @JsonProperty("match_context")
        private List<MatchContext> matchContext;

        @JsonProperty("rule_level")
        private String ruleLevel;

        @JsonProperty("rule_description")
        private String ruleDescription;

        @JsonProperty("rule_author")
        private String ruleAuthor;

        @JsonProperty("rule_id")
        private String ruleId;
    }

    @Data
    public static class MatchContext {
        private Map<String, String> values;
    }

    @Data
    public static class SigmaAnalysisStats {
        private Integer critical;

        private Integer high;

        private Integer low;

        private Integer medium;
    }

    @Data
    public static class SigmaAnalysisSummary {
        private Integer critical;

        private Integer high;

        private Integer low;

        private Integer medium;
    }

    @Data
    public static class TotalVotes {
        private Integer harmless;

        private Integer malicious;
    }

}
