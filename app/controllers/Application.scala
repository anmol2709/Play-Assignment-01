//package controllers
//
//import java.io.File
//
//import models.{User, Login}
//import play.api.cache._
//import play.api.mvc._
//import javax.inject.Inject
//
//
//class Application@Inject()(cache:CacheApi)(services:services.UserService,formControl: FormController) extends Controller{
//
//
//  def index = Action {
//    Ok(views.html.index("Your new application is ready."))
//
//  }
//
//
//
//
//
//  def loginSubmit = {
//    Action { implicit request =>
//      val userLogin: Login = formControl.loginForm.bindFromRequest.get
//      if(services.checkUser(userLogin.userName,userLogin.password))
//      {       val foundUser=services.getUser(userLogin.userName,userLogin.password)
//        Ok(views.html.profile(foundUser))
//      }
//
//      else {
//        Ok(views.html.login())      }
//    }
//  }
//
//
//
//  def signUp= Action {implicit request=>
//    Ok(views.html.signUp())
//  }
//
//  def login= Action {implicit request=>
//    Ok(views.html.login())
//  }
//
//
//  def logout= Action {implicit request=>
//
//    Ok(views.html.index("New Session")).withSession("connected" -> user.userName)
//
//  }
//
//  def upload = Action(parse.temporaryFile) { request =>
//    request.body.moveTo(new File("/home/knoldus/Desktop/Assignment-01/app/1.jpg"))
//    Ok("File uploaded")
//  }
//
//
//
//  def submit = Action { implicit request =>
//    val processedForm = formControl.userForm.bindFromRequest
//    val user: User = formControl.userForm.bindFromRequest.get
//    processedForm.fold(formWithErrors => {
//      BadRequest(" Error ")
//    }, success => {
//      if(cache.get[User](user.userName)== None){
//        services.addUser(user)
//        Ok(views.html.profile(user)).withSession("connected" -> user.userName)
//      }
//      else{
//        Ok(views.html.signUp())
//      }})
//
//  }
//
//}
//
