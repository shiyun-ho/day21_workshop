package sg.moe.nus.iss.day21_workshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    private Integer id; 
    private String lastName; 
    private String firstName; 

    // CREATE TABLE `customers` (
    //     `id` int NOT NULL AUTO_INCREMENT,
    //     `company` varchar(50) DEFAULT NULL,
    //     `last_name` varchar(50) DEFAULT NULL,
    //     `first_name` varchar(50) DEFAULT NULL,
    //     `email_address` varchar(50) DEFAULT NULL,
    //     `job_title` varchar(50) DEFAULT NULL,
    //     `business_phone` varchar(25) DEFAULT NULL,
    //     `home_phone` varchar(25) DEFAULT NULL,
    //     `mobile_phone` varchar(25) DEFAULT NULL,
    //     `fax_number` varchar(25) DEFAULT NULL,
    //     `address` longtext,
    //     `city` varchar(50) DEFAULT NULL,
    //     `state_province` varchar(50) DEFAULT NULL,
    //     `zip_postal_code` varchar(15) DEFAULT NULL,
    //     `country_region` varchar(50) DEFAULT NULL,
    //     `web_page` longtext,
    //     `notes` longtext,
    //     `attachments` longblob,

}
