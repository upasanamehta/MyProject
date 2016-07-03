package expedia.service;

/**
 * Created by umehta on 7/1/16.
 */
public interface IService<TRequest , TResponse> {

    TResponse process (TRequest request);

}
