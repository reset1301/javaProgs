package com.roma;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roma.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("sync")
public class Sync {
    //    public
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    }


    @GET
    @Path("/getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser() throws JsonProcessingException {
        User user = new User("1", "2", "3");
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(user);

    }

    @GET
    @Path("/check/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public String blackCheck(@PathParam("user") String name) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setName(name);
        Map<Integer, User> map = new Black().userMap;
        for (Map.Entry<Integer,User> m: map.entrySet()) {
            if (m.getValue().getName().equals(user.getName())) {
                return mapper.writeValueAsString(m.getKey());
            }
        }

        throw new Exception("Такого юзера нет!");
    }
}
