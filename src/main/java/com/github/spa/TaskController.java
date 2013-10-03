package com.github.spa;

import com.github.spa.dto.Task;
import com.github.spa.repo.TaskRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {
    private static final Log log = LogFactory.getLog(TaskController.class);

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) throws Exception {
        log.debug("spa start");
        return "redirect:/pages/index.html";
    }

    @RequestMapping(value = "/task/add", method = RequestMethod.POST)
    public String addTask(@RequestParam String taskName, String taskOwner, String createdDate) throws Exception {
        Task task = new Task(taskName, taskOwner, createdDate);
        log.debug("task is null?" + (task == null));
        taskRepository.save(task);
        return "redirect:/pages/index.html";
    }

}
