package carlos.holanda.springbootcurso.controller;

import carlos.holanda.springbootcurso.Math.SimpleMath;
import carlos.holanda.springbootcurso.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static carlos.holanda.springbootcurso.converter.NumberConverter.convertToDouble;
import static carlos.holanda.springbootcurso.converter.NumberConverter.isNumeric;

@RestController
@RequestMapping
public class MathController {
    private final AtomicLong counter = new AtomicLong();
    private final SimpleMath simpleMath = new SimpleMath();

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return simpleMath.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return simpleMath.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return simpleMath.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return simpleMath.division(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @GetMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return simpleMath.mean(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @GetMapping("/squareRoot/{number}")
    public Double squareRoot(
            @PathVariable(value = "number") String number) throws Exception {

        if(!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return simpleMath.squareRoot(convertToDouble(number));
    }
}
