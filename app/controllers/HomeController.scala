package controllers

import java.io.File
import play.mvc.QueryStringBindable
import models.{User, Login}
import play.api.cache._
import play.api.mvc.Results._
import play.api.mvc._
import javax.inject.Inject

import services.AbstractUserService


class HomeController@Inject()(formControl: FormController,service:AbstractUserService) extends Controller {


  def index = Action {
    Ok(views.html.index("Your new application is ready."))

  }


  def loginSubmit = {
    Action { implicit request =>
      val userLogin: Login = formControl.loginForm.bindFromRequest.get
      if (service.checkUser(userLogin.userName)) {
        val foundUser = service.getUser(userLogin.userName)
        Ok(views.html.profile(foundUser))
      }

      else {
        Ok(views.html.login())
      }
    }
  }

  def management = Action {

    Ok(views.html.management(service.getList()))
  }

  def signUp = Action { implicit request =>
    Ok(views.html.signUp())
  }

  def login = Action { implicit request =>
    Ok(views.html.login())
  }


  def logout = Action { implicit request =>

    Ok(views.html.index("New Session")).withNewSession

  }

  def upload = Action(parse.temporaryFile) { request =>
    request.body.moveTo(new File("/home/knoldus/Desktop/Assignment-01/app/1.jpg"))
    Ok("File uploaded")
  }


  def submit = Action { implicit request =>
    val processedForm = formControl.userForm.bindFromRequest
    val user: User = formControl.userForm.bindFromRequest.get
    processedForm.fold(formWithErrors => {
      BadRequest(" Error ")
    }, success => {
      if (service.userExist(user.userName) == true) {
        service.addUser(user)
        Ok(views.html.profile(user)).withSession("connected" -> user.userName)
      }
      else {
        Redirect(routes.HomeController.signUp()).flashing(
          "error" -> "User Name Exists")
      }
    })

  }

  def enableUser = Action { implicit request =>
    println("controller")
    request.session.get("connected").map { sessionname =>
      val username = formControl.managementForm.bindFromRequest.get
      service.enable(username)
      Ok(views.html.profile(service.getUser(sessionname))).withSession("connected" -> sessionname)
    }.getOrElse {
      Unauthorized("Oops, you are not connected")
    }

  }

  def disableUser = Action { implicit request =>
    request.session.get("connected").map { sessionname =>
      val username = formControl.managementForm.bindFromRequest.get
      service.disable(username)
      Ok(views.html.profile(service.getUser(sessionname))).withSession("connected" -> sessionname)
    }.getOrElse {
      Unauthorized("Oops, you are not connected")

    }
  }

}

