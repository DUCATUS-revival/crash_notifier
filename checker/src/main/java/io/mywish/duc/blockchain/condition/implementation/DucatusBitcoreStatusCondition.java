package io.mywish.duc.blockchain.condition.implementation;

import io.mywish.duc.blockchain.condition.StatusConditional;
import io.mywish.duc.blockchain.condition.helper.StatusCondition;
import io.mywish.event.service.ConnectionCrushEventCreator;
import io.mywish.event.service.EventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DucatusBitcoreStatusCondition implements StatusConditional {
    private final StatusCondition condition;

    public DucatusBitcoreStatusCondition(
            @Value("${io.mywish.duc.blockchain.attention.status.time}") long attentionTime,
            EventPublisher eventPublisher,
            @Autowired ConnectionCrushEventCreator eventCreator,
            @Value("${io.mywish.duc.blockchain.uri}") String uri,
            @Value("${io.mywish.duc.blockchain.uri.sufix}") String suffix,
            @Value("${io.mywish.duc.blockchain.uri.alias}") String alias) {
        this.condition = new StatusCondition(attentionTime, eventPublisher, eventCreator, "Ducatus", uri, suffix, alias);
    }

    @Override
    public void updateCondition(int status) {
        this.condition.updateStatus(status);
    }

    @Override
    public String getUri() {
        return this.condition.getUriprefix();
    }

    @Override
    public String getSufix() {
        return this.condition.getUrisufix();
    }
}
