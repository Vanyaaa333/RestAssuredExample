package model;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking implements JsonModel {

    @Builder.Default
    @SerializedName("firstname")
    String firstName = "Tester firstname";
    @Builder.Default
    @SerializedName("lastname")
    String lastName = "Tester lastname";
    @Builder.Default
    @SerializedName("totalprice")
    Integer totalPrice = 777;
    @Builder.Default
    @SerializedName("depositpaid")
    Boolean depositPaid = true;
    @Builder.Default
    @SerializedName("bookingdates")
    BookingDates bookingDates = new BookingDates("2018-01-01", "2019-01-01");
    @Builder.Default
    @SerializedName("additionalneeds")
    String additionalNeeds = "Tester additionalneeds";

}