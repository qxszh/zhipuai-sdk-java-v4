package com.zhipu.oapi.service.v4.realtime.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zhipu.oapi.service.v4.realtime.RealtimeServerEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ResponseContentPartDone extends RealtimeServerEvent {
    @JsonProperty("response_id")
    private String responseId;
    @JsonProperty("item_id")
    private String itemId;
    @JsonProperty("output_index")
    private Integer outputIndex;
    @JsonProperty("content_index")
    private Integer contentIndex;
    @JsonProperty("part")
    private String part;

    public ResponseContentPartDone() {
        super.setType("response.content_part.done");
        this.responseId = "";
        this.itemId = "";
        this.outputIndex = 0;
        this.contentIndex = 0;
        this.part = "response.content_part.done";
    }
}
