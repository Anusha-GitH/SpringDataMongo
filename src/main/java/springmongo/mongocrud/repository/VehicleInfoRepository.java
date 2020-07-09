package springmongo.mongocrud.repository;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import springmongo.mongocrud.model.VehicleInfo;

import java.util.Optional;

@Repository
@Document(collection = "VehicleInformation")
public interface VehicleInfoRepository extends MongoRepository<VehicleInfo, String>
{
    @Query(value="{'VIN_number' : ?0 ,'production_year' :?1}")
    Optional<VehicleInfo> findByVIn(String VIN_number,int prd_year);
}
