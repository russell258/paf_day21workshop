package sg.edu.nus.iss.paf_day21workshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;    
}
