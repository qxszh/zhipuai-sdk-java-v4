package com.zhipu.oapi.service.v4.realtime.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SessionConfig {
    @JsonProperty("object")
    private String object;
    @JsonProperty("id")
    private String id;
    @JsonProperty("model")
    private String model;
    @JsonProperty("modalities")
    private List<String> modalities;
    @JsonProperty("voice")
    private String voice;
    @JsonProperty("instructions")
    private String instructions;
    @JsonProperty("input_audio_format")
    private String inputAudioFormat;
    @JsonProperty("output_audio_format")
    private String outputAudioFormat;
    @JsonProperty("input_audio_transcription")
    private InputAudioTranscriptionObj inputAudioTranscription;
    @JsonProperty("turn_detection")
    private TurnDetectionObj turnDetection;
    @JsonProperty("tools")
    private List<ToolConfig> tools;
    @JsonProperty("tool_choice")
    private String toolChoice;
    @JsonProperty("temperature")
    private Double temperature;
    @JsonProperty("max_response_output_tokens")
    private Double maxResponseOutputTokens;
    @JsonProperty("beta_fields")
    private BetaFieldObj betaFields;

    public SessionConfig() {
        this.object = null;
        this.id = null;
        this.modalities = List.of("text", "audio");
        this.model = null;
        this.instructions = null;
        this.voice = "tongtong";
        this.inputAudioFormat = "pcm16";
        this.outputAudioFormat = "pcm16";
        this.inputAudioTranscription = new InputAudioTranscriptionObj();
        this.turnDetection = new TurnDetectionObj();
        this.tools = List.of();
        this.toolChoice = "auto";
        this.temperature = 0.8;
        this.maxResponseOutputTokens = 0.5;
        this.betaFields = new BetaFieldObj();
        // 临时处理
        this.object = null;
        this.id = null;
        this.modalities = null;
        this.model = null;
        this.instructions = null;
        this.inputAudioTranscription = null;
        this.voice = null;
        this.toolChoice = null;
        this.temperature = null;
        this.maxResponseOutputTokens = null;
        // 暂时不支持字段
        this.toolChoice = null;
    }
}
