package sk.stuba.fei.oop.cvicenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserController {

    @Autowired
    private UserService basicService;

    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendPozdrav(@PathVariable("name") String name) {
        return this.basicService.sendPozdrav(name);
    }

    @RequestMapping(value = "/usersObj/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> sendPozdravObjekt(@PathVariable("name") String name) {
        return new ResponseEntity<User>(this.basicService.sendPozdravObjekt(name), HttpStatus.OK);
    }

    @RequestMapping(value = "/usersObjGet/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> sendPozdravObjektGet(@PathVariable("id") Long id) {

        if (this.basicService.sendPozdravObjektGet(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
