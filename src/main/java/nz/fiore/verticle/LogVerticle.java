package nz.fiore.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

import java.time.Instant;

/**
 * Created by fiorenzo on 21/01/17.
 */
public class LogVerticle extends AbstractVerticle {

    private static final Logger logger = LoggerFactory.getLogger(LogVerticle.class);


    @Override
    public void start(Future<Void> future) throws Exception {

        Router router = Router.router(vertx);
        // static content
        router.route("/*").handler(StaticHandler.create());
        int port = config().getInteger("log.port", 8081);
        logger.info("port: " + port);
        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(port);
        vertx.setPeriodic(1000, id -> {
            logger.info("loggo di brutto: " + Instant.now());
        });
    }
}
