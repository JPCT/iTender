import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let token = localStorage.getItem('token')
        
        if (token != null) {
            if (request.method === 'POST' && request.url.indexOf('/api/product') >= 0){
                const authReq = request.clone({
                    headers: request.headers.set('Authorization', 'Bearer '+token)
    
                });

                return next.handle(authReq);
            }
            const authReq = request.clone({
                headers: request.headers.set('Authorization', 'Bearer '+token)
                                        .set('Content-Type', 'application/json')

            });
            
            return next.handle(authReq);
        }

        return next.handle(request);
    }
}