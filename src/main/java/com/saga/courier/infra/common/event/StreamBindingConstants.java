package com.saga.courier.infra.common.event;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamBindingConstants {
    public static final String UPDATE_SHIPMENT_STATUS = "workflow-courier-create-response";
    public static final String PACKAGE_DELIVERED = "workflow-courier-delivered-response";
}
