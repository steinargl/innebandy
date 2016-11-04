
package no.sag.innebandy;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Layout;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.status.ErrorStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class SlackAppender extends UnsynchronizedAppenderBase<ILoggingEvent>
{
    private String endpoint;//https://hooks.slack.com/services/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
    private Level level;
    private Layout<ILoggingEvent> layout;

    @Override
    public void start()
    {
        int errors = 0;
       /* if (level == null) {
            addStatus(new ErrorStatus("No level set for the appender named \"" + name + "\".", this));
            errors++;
        }*/
        if (endpoint == null) {
            addStatus(new ErrorStatus("No endpoint set for the appender named \"" + name + "\".", this));
            errors++;
        }
        if (layout == null) {
            addStatus(new ErrorStatus("No layout set for the appender named \"" + name + "\".", this));
            errors++;
        }
        if (errors == 0) {
            super.start();
        }
    };

    @Override
    protected void append(ILoggingEvent evt)
    {
        if (!isStarted()) {
            return;
        }

        /*if (evt.getLevel().isGreaterOrEqual(level))
        {*/
            final HttpPost post = new HttpPost(endpoint);
            post.addHeader("Content-Type", "application/json");

            StringEntity entity = null;

            try {
                entity = new StringEntity("{\"text\":\"" + layout.doLayout(evt) + "\"}");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            post.setEntity(entity);

            try (CloseableHttpClient httpClient = HttpClientBuilder.create().build())
            {
                HttpResponse response = httpClient.execute(post);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
       // }
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Layout<ILoggingEvent> getLayout() {
        return layout;
    }

    public void setLayout(Layout<ILoggingEvent> layout) {
        this.layout = layout;
    }
}
