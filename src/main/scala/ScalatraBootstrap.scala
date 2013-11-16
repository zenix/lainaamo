import com.jaritimonen.lainaamo.domain.LainaamoService
import com.jaritimonen.lainaamo.infrastructure.BookRepository
import com.jaritimonen.lainaamo.ui.LainaamoServlet
import com.mongodb.casbah.MongoConnection
import org.scalatra._
import javax.servlet.ServletContext
import com.mongodb.casbah.Imports._

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new LainaamoServlet{
      var lainaamoService = new LainaamoService{
        var bookRespository: BookRepository = new BookRepository{
          var collection: MongoCollection = MongoConnection()("lainaamo")("books")
        }
      }
    }, "/api/*")
  }
}
