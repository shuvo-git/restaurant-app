package com.jobayed.orderservice.utility;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 4:44 PM
 */

public class Constants {
    public static class FeatureCode {
        public static final String ORDER = "001";
        public static final String SALES = "002";
    }

    public class Topic {
        public static final String CUSTOMER = "customer";
        public static final String ORDER = "orders";

        public class Key {
            public static final String ORDER = "orders_";
        }

        public class Group {
            public static final String CUSTOMER = "customer_Group";
            public static final String ORDER = "orders_Group";
        }
    }

    public class OrderState {
        public class Message {
            public static final String PENDING = "Your order is being processed.";
        }
    }
}
