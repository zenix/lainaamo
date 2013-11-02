import com.jaritimonen.lainaamo._
import com.jaritimonen.lainaamo.domain.LainaamoService
import com.jaritimonen.lainaamo.ui.LainaamoServlet
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new LainaamoServlet{
      var lainaamoService = new LainaamoService
    }, "/api/*")
  }
}
