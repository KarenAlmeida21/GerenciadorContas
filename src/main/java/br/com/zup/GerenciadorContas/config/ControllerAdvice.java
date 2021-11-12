package br.com.zup.GerenciadorContas.config;
import br.com.zup.GerenciadorContas.exceptions.ContaNaoLocalizadaException;
import br.com.zup.GerenciadorContas.exceptions.StatusInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public java.util.List<ComunicacaoDeFalha> tratarErrosDeValidacao (MethodArgumentNotValidException excecao){
        List<ComunicacaoDeFalha>erros= new ArrayList<>();


        for (FieldError referencia : excecao.getFieldErrors()){
            ComunicacaoDeFalha comunicacaoDeFalha = new ComunicacaoDeFalha(referencia.getDefaultMessage());

            erros.add(comunicacaoDeFalha);
        }

        return  erros;

    }

    @ExceptionHandler(ContaNaoLocalizadaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ComunicacaoDeFalha contaNaoLocalizada(ContaNaoLocalizadaException exception){
        return new ComunicacaoDeFalha(exception.getMessage());
    }
    @ExceptionHandler(StatusInvalidoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ComunicacaoDeFalha statusInvalido(StatusInvalidoException exception){
        return new ComunicacaoDeFalha((exception.getMessage()));
    }

}
