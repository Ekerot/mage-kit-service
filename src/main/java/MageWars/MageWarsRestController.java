package MageWars;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ekerot on 2016-06-11.
 */

@Controller
public class MageWarsRestController {


    private final Logger logger = LoggerFactory.getLogger(MageWarsRestController.class);

    @RequestMapping(value = "/magewars", method = RequestMethod.GET)
    public
    @ResponseBody
    String displayTemplateJSON() throws Exception {
        logger.info("displayTemplateJSON() method invoked.");
        Map<String, Object> dataStructure = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        Gson gson = new Gson();

// build a simple data structure
        dataStructure.put("dataStructure", getStructure());
        logger.info("displayTemplateJSON(), building data structure.");

// convert Map to JSON
        String json = gson.toJson(dataStructure, Map.class);
        logger.info("displayTemplateJSON(), converting data structure to JSON.");

        if (json != null) {
            logger.info("displayTemplateJSON(), returning data structure as JSON.");
            return json;
        }

        return "\"{ \"No data foundl.\"}\"";
    }

    private Map<String, Object> getStructure() {
        Map<String, Object> data = new HashMap<>();
        data.put("Task", "A full fledge Mage Wars Webb application.");
        data.put("Team", "Brutus");

        List<String> requestTypes = new ArrayList<>();
        requestTypes.add("RequestTypeOne");
        requestTypes.add("RequestTypeTwo");
        requestTypes.add("RequestTypeThree");
        requestTypes.add("RequestTypeFour");
        requestTypes.add("RequestTypeFive");
        requestTypes.add("RequestTypeSix");
        requestTypes.add("RequestTypeSeven");
        requestTypes.add("RequestTypeEight");
        data.put("RequestTypes", requestTypes);

        logger.info("displayTemplateJSON(), data structure is: {}", data);
        return data;
    }

}
