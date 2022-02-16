package de.kittlaus.friday2spring.github;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/github")
public class GitHubController {


    @GetMapping("/{username}")
    public String [] getRepositoyNames (@PathVariable String username) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Repository[]> response = template.getForEntity("https://api.github.com/users/" + username + "/repos", Repository[].class);
        String [] returnvalue =  new String[response.getBody().length];
        for (int i = 0; i< returnvalue.length; i++) {
            returnvalue[i] = response.getBody()[i].getName();
        }
        return returnvalue;
    }



}
