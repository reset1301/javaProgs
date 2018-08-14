package com.roma;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roma.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("async")
public class Async {

    @GET
    @Path("/getuserasync")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserAsync() throws JsonProcessingException, InterruptedException {
        Thread.sleep(5000);

        return new ObjectMapper().writeValueAsString(new User("q", "w", "e"));
    }

    @GET
    @Path("/check/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public String blackCheck(@PathParam("user") String name) throws Exception {

        Thread.sleep(getRandomValue());
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setName(name);
        Map<Integer, User> map = new Black().userMap;
        for (Map.Entry<Integer, User> m : map.entrySet()) {
            if (m.getValue().getName().equals(user.getName())) {
                String s = mapper.writeValueAsString(m.getValue());
                return s;
            }
        }

        throw new Exception("Такого юзера нет!");
    }

    public long getRandomValue() {
        return (long) (Math.random() * 4500 + 500);
    }
}
