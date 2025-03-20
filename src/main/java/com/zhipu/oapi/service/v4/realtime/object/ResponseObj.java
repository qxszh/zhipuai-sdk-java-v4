package com.zhipu.oapi.service.v4.realtime.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ResponseObj {
    @SerializedName("modalities")
    private List<String> modalities;
    @SerializedName("instructions")
    private String instructions;
    @SerializedName("voice")
    private String voice;
    @SerializedName("output_audio_format")
    private String outputAudioFormat;
    @JsonProperty("tools")
    private List<ToolConfig> tools;
    @SerializedName("tool_choice")
    private String toolChoice;
    @SerializedName("temperature")
    private Double temperature;
    @SerializedName("max_output_tokens")
    private ConfigIntOrInf maxOutputTokens;
    @SerializedName("conversation")
    private String conversation;
    @SerializedName("metadata")
    private Map<String, String> metadata;
    @SerializedName("input")
    private List<Object> input;

    public ResponseObj() {
        this.modalities = ImmutableList.of("text", "audio");
        this.instructions = "";
        this.voice = "alloy";
        this.outputAudioFormat = "pcm16";
        this.tools = ImmutableList.of();
        this.toolChoice = "auto";
        this.temperature = 0.7;
        this.maxOutputTokens = ConfigIntOrInf.inf();
        this.conversation = "";
        this.metadata = Map.of();
        this.input = List.of();
    }
}