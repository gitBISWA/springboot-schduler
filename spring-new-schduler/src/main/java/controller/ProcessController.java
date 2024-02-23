package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProcessService; 
@RestController
public class ProcessController {

    private final ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @GetMapping("/start-process")
    public String startProcess() {
        processService.startAndWait();
        return "Process completed!";
    }
  //   @GetMapping("/restart-process")
    @PostMapping("/restart-process")
    public String restartProcess() {
        processService.restart();
        return "Process restarted!";
    }
}
