import java.util.concurrent.atomic.AtomicLong;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class UserIntegration extends RouteBuilder {

    
    public void configure() throws Exception {

       
        from("kafka:userX-lyft?brokers=hack-cluster-kafka-bootstrap.streams.svc:9092")
                .to("direct:process");

        from("kafka:serX-uber?brokers=hack-cluster-kafka-bootstrap.streams.svc:9092")
                .to("direct:process");


        from("direct:process")
                ;

       
    }

    public static VehicleInfo buildLyft(long vehicleId, double pricePerMinute, long timeToPickup, int availableSpace, boolean available) {
        VehicleInfo v = new VehicleInfo();
        v.setProvider("LYFT");
        v.setVehicleId(vehicleId);
        v.setPricePerMinute(pricePerMinute);
        v.setTimeToPickup(timeToPickup);
        v.setAvailableSpace(availableSpace);
        v.setAvailable(available);

        return v;
    }

    public static class VehicleInfo {

        private String provider;

        private long vehicleId;

        private double pricePerMinute;

        private double price;

        private long timeToPickup;

        private int availableSpace;

        private boolean available;

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public long getVehicleId() {
            return vehicleId;
        }

        public void setVehicleId(long vehicleId) {
            this.vehicleId = vehicleId;
        }

        public double getPricePerMinute() {
            return pricePerMinute;
        }

        public void setPricePerMinute(double pricePerMinute) {
            this.pricePerMinute = pricePerMinute;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public long getTimeToPickup() {
            return timeToPickup;
        }

        public void setTimeToPickup(long timeToPickup) {
            this.timeToPickup = timeToPickup;
        }

        public int getAvailableSpace() {
            return availableSpace;
        }

        public void setAvailableSpace(int availableSpace) {
            this.availableSpace = availableSpace;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        @Override
        public String toString() {
            return "VehicleInfo{" +
                    "provider='" + provider + '\'' +
                    ", vehicleId=" + vehicleId +
                    ", pricePerMinute=" + pricePerMinute +
                    ", price=" + price +
                    ", timeToPickup=" + timeToPickup +
                    ", availableSpace=" + availableSpace +
                    ", available=" + available +
                    '}';
        }
    }

    

}
