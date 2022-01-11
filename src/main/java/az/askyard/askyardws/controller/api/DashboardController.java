package az.askyard.askyardws.controller.api;

import az.askyard.askyardws.business.abstracts.DashboardService;
import az.askyard.askyardws.business.abstracts.UserService;
import az.askyard.askyardws.core.annotations.CurrentUser;
import az.askyard.askyardws.core.concretes.utilities.result.DataResult;
import az.askyard.askyardws.core.concretes.utilities.result.Result;
import az.askyard.askyardws.entities.concretes.dto.UserDashboard;
import az.askyard.askyardws.entities.concretes.post.Post;
import az.askyard.askyardws.entities.concretes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/post",produces = MediaType.APPLICATION_JSON_VALUE)
public class DashboardController  {

    private DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @PostMapping("/posted")
    public ResponseEntity<Result> post(@CurrentUser  User user, Post post) {
        return new ResponseEntity<Result>(this.dashboardService.post(user,post), HttpStatus.OK);
    }


    public Result likePost(@CurrentUser  User user, Long postId) {
        return null;
    }


    public Result unlikePost(@CurrentUser  User user, Long postId) {
        return null;
    }


    public Result deletePost(@CurrentUser  User user, Long postId) {
        return null;
    }


    public Result updatePost(@CurrentUser  User user, Long postId) {
        return null;
    }


    public Result reportPost(@CurrentUser  User user, Long postId, String message) {
        return null;
    }


    public Result commentToPost(@CurrentUser  User user, Long postId) {
        return null;
    }


    @GetMapping("/dash")
    public ResponseEntity<DataResult<List<UserDashboard>>> getDashboard(@CurrentUser  User user) {
        return new ResponseEntity<DataResult<List<UserDashboard>>>(this.dashboardService.getDashboard(user),HttpStatus.OK);
    }

}
