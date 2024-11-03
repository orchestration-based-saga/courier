package com.saga.courier.infra.common.event;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamBindingConstants {
    public static final String UPDATE_SHIPMENT_STATUS = "workflow-courier-assign-response";
    public static final String PACKAGE_DELIVERED = "workflow-courier-delivered-response";
    public static final String WAREHOUSE_NOTIFIED = "workflow-courier-notify-warehouse-response";
}
