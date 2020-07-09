package springmongo.mongocrud.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springmongo.mongocrud.exceptions.ResourceNotFoundException;
import springmongo.mongocrud.model.DatabaseSequence;
import springmongo.mongocrud.model.VehicleInfo;
import springmongo.mongocrud.repository.VehicleInfoRepository;
import springmongo.mongocrud.service.SequenceGeneratorService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vehicle")
public class VehicleInfoController {

    @Autowired
    private VehicleInfoRepository vehicleRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/vehicles")
    public List<VehicleInfo> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/vehicle/{vin}")
    public ResponseEntity<Optional<VehicleInfo>> getVehiclebyVIN(@PathVariable String vin)
            throws ResourceNotFoundException {
        Optional<VehicleInfo> veh = vehicleRepository.findByVIn(vin);
              //  .orElseThrow(() -> new ResourceNotFoundException("No Vehicle found with this id :: " + VIN_number));
        return ResponseEntity.ok().body(veh);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Optional<VehicleInfo>> getVehiclebyId(@PathVariable String id)
            throws ResourceNotFoundException {
        Optional<VehicleInfo> veh = vehicleRepository.findById(id);
        //  .orElseThrow(() -> new ResourceNotFoundException("No Vehicle found with this id :: " + VIN_number));
        return ResponseEntity.ok().body(veh);
    }



    @GetMapping("/vehicles1/{gmp}")
    public ResponseEntity<String> getVehiclebyVIN1(@PathVariable(value = "gmp") String vin)
            throws ResourceNotFoundException {
       String resp ="VIN entered is :"+vin;
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping("/insert")
    public ResponseEntity<Optional<VehicleInfo>> Insert3Records () {
        List<VehicleInfo> allVeh = new ArrayList<VehicleInfo>() ;

        VehicleInfo v2 =new VehicleInfo();
        v2.setVIN_number("SAJDD1GX_N");
        v2.setProduction_year(2021);
        v2.setVehicle_make_name("Jaguar");
        v2.setVehicle_model_name("F-TYPE COUPE 2D 2WD");

        VehicleInfo v3 =new VehicleInfo();
        v3.setVIN_number("SAJDD1GX_P");
        v3.setProduction_year(2021);
        v3.setVehicle_make_name("Jaguar");
        v3.setVehicle_model_name("F-TYPE COUPE 2D 2WD");

        vehicleRepository.save(v3);

        Optional<VehicleInfo> veh = vehicleRepository.findByVIn("SAJDD1GX_O");
        //  .orElseThrow(() -> new ResourceNotFoundException("No Vehicle found with this id :: " + VIN_number));
        return ResponseEntity.ok().body(veh);

    }

    /*@PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/
}
