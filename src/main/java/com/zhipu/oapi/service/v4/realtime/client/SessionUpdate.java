package com.zhipu.oapi.service.v4.realtime.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zhipu.oapi.service.v4.realtime.RealtimeClientEvent;
import com.zhipu.oapi.service.v4.realtime.object.SessionConfig;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class SessionUpdate extends RealtimeClientEvent {
    @JsonProperty("session")
    private SessionConfig session;

    public SessionUpdate() {
        super();
        this.setType("session.update");
        this.session = new SessionConfig();
    }
}