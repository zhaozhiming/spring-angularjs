package com.github.spa;

import com.github.spa.dto.Task;
import com.github.spa.repo.TaskRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TaskController {
    private static final Log log = LogFactory.getLog(TaskController.class);

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws Exception {
        log.debug("spa start");
        return "redirect:/pages/index.html";
    }

    @RequestMapping(value = "/task/add", method = RequestMethod.POST)
    public String addTask(@RequestParam String taskName, String taskOwner, String createdDate) throws Exception {
        Task task = new Task(taskName, taskOwner, createdDate);
        taskRepository.save(task);
        return "redirect:/pages/index.html";
    }

    @RequestMapping(value = "/task/all", method = RequestMethod.GET)
    public
    @ResponseBody
    String list() throws JSONException {
        List<Task> tasks = taskRepository.findAll();

        JSONArray tasksJson = new JSONArray();
        for (Task task : tasks) {
            JSONObject taskJson = new JSONObject();
            taskJson.put("id", task.getId());
            taskJson.put("name", task.getName());
            taskJson.put("owner", task.getOwner());
            taskJson.put("createdDate", task.getCreatedDate());
            tasksJson.put(taskJson);
        }
        return tasksJson.toString();
    }


}
