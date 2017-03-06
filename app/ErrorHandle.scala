
import play.api.http.HttpErrorHandler
import play.api.mvc._
import play.api.mvc.Results._
import scala.concurrent._
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future

class ErrorHandler extends HttpErrorHandler {

  def onClientError(request: RequestHeader, statusCode: Int, message: String) = {
    statusCode match {
      case 400 => Future.successful(Status(statusCode)( statusCode + "-Bad Request !!!!!!!"))
      case 404 => Future.successful(Status(statusCode)( statusCode + "-Page not found !!!!!!!"))
      case 401 => Future.successful(Status(statusCode)( statusCode + "-Unauthorized !!!!!!!"))

    }
  }
  def onServerError(request: RequestHeader, exception: Throwable) = {
    Future.successful(
      Ok(views.html.signUp())
    )
  }
}