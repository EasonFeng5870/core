package com.eason.springmvc.converter;

import com.eason.springmvc.domain.SimpleMessage;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by feng yingsheng on 10/4/2017.
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<SimpleMessage> {

    public MyMessageConverter(){
        super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return SimpleMessage.class.isAssignableFrom(clazz);
    }

    @Override
    protected SimpleMessage readInternal(Class<? extends SimpleMessage> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return new SimpleMessage(new Long(tempArr[0]), tempArr[1]);
    }

    @Override
    protected void writeInternal(SimpleMessage simpleMessage, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        String out = "hello:" + simpleMessage.getId() + "-" + simpleMessage.getName();
        outputMessage.getBody().write(out.getBytes());
    }
}
