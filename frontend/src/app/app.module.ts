import { NgModule }         from '@angular/core';
import { BrowserModule }    from '@angular/platform-browser';
import { FormsModule }      from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientXsrfModule } from '@angular/common/http';


import { RequestCache, RequestCacheWithMap } from './request-cache.service';

import { AppComponent }         from './app.component';
import { AuthService }          from './auth.service';
import { ConfigComponent }      from './config/config.component';
import { DownloaderComponent }  from './downloader/downloader.component';
import { HeroesComponent }      from './heroes/heroes.component';
import { HttpErrorHandler }     from './http-error-handler.service';
import { MessageService }       from './message.service';
import { HeroesService }       from './heroes/heroes.service';
import { MessagesComponent }    from './messages/messages.component';
import { PackageSearchComponent } from './package-search/package-search.component';
import { UploaderComponent }    from './uploader/uploader.component';

import { httpInterceptorProviders } from './http-interceptors/index';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    // import HttpClientModule after BrowserModule.
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'My-Xsrf-Cookie',
      headerName: 'My-Xsrf-Header',
    })
  ],
  declarations: [
    AppComponent,
    ConfigComponent,
    DownloaderComponent,
    HeroesComponent,
    MessagesComponent,
    UploaderComponent,
    PackageSearchComponent,
  ],
  providers: [
    AuthService,
    HttpErrorHandler,
    MessageService,
    HeroesService,
    { provide: RequestCache, useClass: RequestCacheWithMap }
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {}