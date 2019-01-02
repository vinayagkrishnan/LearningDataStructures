package com.UmmuLearns.lombok;

public class ImmutableExample {

    static class Configuration {

        final static int DEFAULT_RETIES = 3;

        final int timeout;
        final int maxConnections;
        final int numRetries;

        Configuration(int timeout, int maxConnections, int numRetries) {
            this.timeout = timeout;
            this.maxConnections = maxConnections;
            this.numRetries = numRetries;
        }

        // NOTE : Builder Pattern
        static class Builder {
            int timeout;
            int maxCons;

            Builder() {

            }

            public Builder timeout(int t) {
                timeout = t;
                return this;
            }

            public Builder maxConnections(int m) {
                maxCons = m;
                return this;
            }

            public Configuration build() {

                return new Configuration(timeout, maxCons, 0);
            }


        }

    }


    public static void main(String[] args) {
        Configuration config = new Configuration(10, 5, 3);
        // final Configuration finalConfig = new Configuration(10, 100, 0);

        // config = finalConfig;

        Configuration configUsingBuilder = new Configuration.Builder()
                                                                .maxConnections(10)
                                                                .timeout(3)
                                                                .build();
//        configBuilder.timeout(3);

//        config = configBuilder.build();


    }

}
