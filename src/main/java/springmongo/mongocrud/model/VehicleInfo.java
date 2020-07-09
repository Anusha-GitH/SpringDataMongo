package springmongo.mongocrud.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.util.Collection;

@Document(collection = "VehicleInformation")
public class VehicleInfo {


    public  VehicleInfo()
    {

    }

    @Id
    public  String id;

    private int vehicle_make_id;
    private String vehicle_make_name;
    @Indexed
    private String VIN_number;
    private int production_year;
    private int Vehicle_model_id;    private String Vehicle_model_name;
    private int body_btyle_id;    private String body_btyle_name;
    private int price_new;

    public void setVIN_number(String VIN_number) {
        this.VIN_number = VIN_number;
    }

    public String getVIN_number() {
        return this.VIN_number;
    }

    public void setProduction_year(int production_year) {
        this.production_year = production_year;
    }

    public int getProduction_year() {
        return this.production_year;
    }

    public void setVehicle_make_id(int vehicle_make_id) {
        this.vehicle_make_id = vehicle_make_id;
    }

    public int getVehicle_make_id() {
        return this.vehicle_make_id;
    }

    public void setVehicle_make_name(String vehicle_make_name) {
        this.vehicle_make_name = vehicle_make_name;
    }

    public String getVehicle_make_name() {
        return this.vehicle_make_name;
    }

    public void setVehicle_model_id(int Vehicle_model_id) {
        this.Vehicle_model_id = Vehicle_model_id;
    }

    public int getVehicle_model_id() {
        return this.Vehicle_model_id;
    }

    public void setVehicle_model_name(String Vehicle_model_name) {
        this.Vehicle_model_name = Vehicle_model_name;
    }

    public String getVehicle_model_name() {
        return this.Vehicle_model_name;
    }

    public void setBody_btyle_id(int body_btyle_id) {
        this.body_btyle_id = body_btyle_id;
    }

    public int getBody_btyle_id() {
        return this.body_btyle_id;
    }

    public void setBody_btyle_name(String body_btyle_name) {
        this.body_btyle_name = body_btyle_name;
    }

    public String getBody_btyle_name() {
        return this.body_btyle_name;
    }

    public void setPrice_new(int price_new) {         this.price_new = price_new;    }

    public int getPrice_new() {        return this.price_new;    }

    @Override
    public String toString() {
        return "VehicleInfo [id=" + id + ", vehicle_make_id=" + vehicle_make_id + ", vehicle_make_name=" + vehicle_make_name + "," +
                " Vehicle_model_id=" +  Vehicle_model_id+", Vehicle_model_name=" +Vehicle_model_name +",production_year ="+production_year
                +",price_new ="+price_new+",body_btyle_id ="+body_btyle_id+",body_btyle_name"+body_btyle_name+"]";
    }

}

