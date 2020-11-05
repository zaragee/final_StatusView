package pizza;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="StatusView_table")
public class StatusView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long orderId;
        private String orderStatus;
        private String deliveryStatus;
        private Long eventId;
        private String eventStatus;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }
        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
        public String getDeliveryStatus() {
            return deliveryStatus;
        }

        public void setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }
        public Long getEventId() {
            return eventId;
        }

        public void setEventId(Long eventId) {
            this.eventId = eventId;
        }
        public String getEventStatus() {
            return eventStatus;
        }

        public void setEventStatus(String eventStatus) {
            this.eventStatus = eventStatus;
        }

}
