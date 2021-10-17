package by.training.barbershop.service.validator;

public class ValidatorRepeatPassword {
    public boolean isSubmittedPassword(String password,String repeatedPassword){
        return password.equals(repeatedPassword);
    }
}
