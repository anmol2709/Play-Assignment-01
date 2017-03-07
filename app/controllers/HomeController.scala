package controllers

import java.io.File
import javax.inject._
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.Results._
import play.api.mvc._
import sun.security.util.Password
import views.html
import views.html.helper.form

import scala.collection.mutable.ListBuffer

case class User(firstName: String,middleName:String,lastName:String,userName:String,password: String,verifyPassword:String,mobileNumber:String    ,gender:String, age: Int,hobbies:String)
case class Login(userName:String , password: String)

@Singleton
class HomeController @Inject() extends Controller {

val formControl=new FormController

  def index = Action {
    Ok(views.html.index("Your new application is ready."))

  }



  def loginSubmit = {
    Action { implicit request =>
      val userLogin: Login = formControl.loginForm.bindFromRequest.get
          if(services.UserList.checkUser(userLogin.userName,userLogin.password))
      {       val foundUser=services.UserList.getUser(userLogin.userName,userLogin.password)
        Ok(views.html.profile(foundUser)).withSession("connected" -> foundUser.userName)
      }

        else {
          Ok(views.html.login())      }
    }
  }



    def signUp= Action {implicit request=>
      Ok(views.html.signUp())
    }

  def login= Action {implicit request=>
    Ok(views.html.login())
  }


  def logout= Action {implicit request=>

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
if(!services.UserList.userList.map(x=>x.userName==user.userName).contains(true)){
      services.UserList.addUser(user)
      Ok(views.html.profile(user)).withSession("connected" -> user.userName)
    }
    else{
      Ok(views.html.signUp())
    }})

  }


}


