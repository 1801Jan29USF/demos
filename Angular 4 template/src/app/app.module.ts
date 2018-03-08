import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';

import { appRoutes } from './routes';
import { FirstComponent } from './components/first/first.component';
import { SecondComponent } from './components/second/second.component';
import { ClickerComponent } from './components/clicker/clicker.component';
import { HeroComponent } from './components/hero/hero.component';
import { HeroesComponent } from './components/heroes/heroes.component';
import { PipeDemoComponent } from './components/pipe-demo/pipe-demo.component';
import { HeroPowerPipe } from './pipes/hero-power.pipe';
import { HeroService } from './services/hero.service';
import { ParentComponent } from './components/parent/parent.component';
import { Child1Component } from './componenets/parent/child1/child1.component';
import { Child2Component } from './components/parent/child2/child2.component';
import { Child3Component } from './components/parent/child3/child3.component';
import { Child4Component } from './components/parent/child4/child4.component';
import { Child5Component } from './components/parent/child5/child5.component';
import { Child6Component } from './components/parent/child6/child6.component';
import { ParamRouteComponent } from './components/param-route/param-route.component';
import { ParamParentComponent } from './components/param-parent/param-parent.component';
import { PokemonComponent } from './components/pokemon/pokemon.component';
import { LoginComponent } from './components/login/login.component';
import { UsersComponent } from './components/users/users.component';
import { LoggedInGuard } from './guards/logged-in.guard';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { TicTacToeComponent } from './components/tic-tac-toe/tic-tac-toe.component';
import { SpringComponent } from './components/spring/spring.component';


@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes, {useHash: true}),
    FormsModule
  ],
  declarations: [
    AppComponent,
    NavComponent,
    FirstComponent,
    SecondComponent,
    ClickerComponent,
    HeroComponent,
    HeroesComponent,
    PipeDemoComponent,
    HeroPowerPipe,
    ParentComponent,
    Child1Component,
    Child2Component,
    Child3Component,
    Child4Component,
    Child5Component,
    Child6Component,
    ParamRouteComponent,
    ParamParentComponent,
    PokemonComponent,
    LoginComponent,
    UsersComponent,
    TicTacToeComponent,
    SpringComponent
  ],
  providers: [
    HeroService,
    LoggedInGuard,
    CookieService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
