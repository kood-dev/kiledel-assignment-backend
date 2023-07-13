package com.kiledel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

@ExtendWith(RestDocumentationExtension.class)
public abstract class AbstractControllerTest {
    protected MockMvc mockMvc;

    protected ObjectMapper objectMapper;

    @BeforeEach
    protected void setup(WebApplicationContext context, RestDocumentationContextProvider provider) {
        this.mockMvc= MockMvcBuilders.webAppContextSetup(context)
                .apply(MockMvcRestDocumentation.documentationConfiguration(provider))
                .addFilters(new CharacterEncodingFilter("UTF-8",true))
                .build();

        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    }


    public static OperationRequestPreprocessor getDocumentRequest() {
        return preprocessRequest(
                modifyUris()
                        .scheme("https")
                        .host("domain.com")
                        .removePort(),
                prettyPrint());
    }

    public static OperationResponsePreprocessor getDocumentResponse() {
        return preprocessResponse(prettyPrint());
    }

    public static ResponseFieldsSnippet commonResponseFields(FieldDescriptor... descriptors) {
        return PayloadDocumentation.responseFields(
                        fieldWithPath("code").type(JsonFieldType.STRING).description("요청 결과 코드"),
                        fieldWithPath("message").type(JsonFieldType.STRING).description("요청 결과 메세지"))
                .and(descriptors);
    }

    public static ResponseFieldsSnippet commonResponseFields(boolean isCollection, FieldDescriptor... descriptors) {
        return PayloadDocumentation.responseFields(
                fieldWithPath("code").type(JsonFieldType.STRING).description("요청 결과 코드"),
                fieldWithPath("message").type(JsonFieldType.STRING).description("요청 결과 메세지")).and(
                Arrays.stream(descriptors)
                        .map(fd -> {
                            if (fd.isOptional()) {
                                return fieldWithPath((isCollection ? "data[]." : "data.") + fd.getPath()).type(fd.getType()).optional().description(fd.getDescription());
                            } else {
                                return fieldWithPath((isCollection ? "data[]." : "data.") + fd.getPath()).type(fd.getType()).description(fd.getDescription());
                            }
                        })
                        .collect(Collectors.toList()));
    }
}
