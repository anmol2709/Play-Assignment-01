package controllers

import models.{Login, User}
import play.api.data._
import play.api.data.Forms._
import play.api.mvc.{Request, Action, Controller}

class FormController extends Controller{





  val userForm = Form(
    mapping(
      "firstName" -> nonEmptyText,
      "middleName" -> text,
      "lastName" -> nonEmptyText,
      "userName" -> nonEmptyText,
      "password" -> nonEmptyText,
      "verifyPassword"->nonEmptyText,
      "isEnabled"->boolean,
      "userRole"-> boolean,
      "mobileNumber" -> nonEmptyText,
      "gender" -> nonEmptyText,
      "age" -> number(min = 18, max = 75),
      "hobbies" -> text
    )(User.apply)(User.unapply).verifying("Passwords do not match", fields => fields match {
      case data => (data.password == data.verifyPassword)
    }
    ))

  val loginForm = Form(
    mapping(
      "userName" -> nonEmptyText,
      "password" -> nonEmptyText
    )(Login.apply)(Login.unapply)
  )

  val managementForm = Form(
    single(
      "username" -> text
    )
  )




}