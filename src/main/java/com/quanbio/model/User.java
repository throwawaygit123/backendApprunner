package com.quanbio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user")
public class User {
	@Id	
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id; 

    private String firstname;
    private String middleName;
    private String familyname ;
    private String email;
    private String password;
    private String gender;
    // Should b date 
    private String birthday;
 
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

   
}

