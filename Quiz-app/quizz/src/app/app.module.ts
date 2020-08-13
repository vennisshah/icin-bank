import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TakequizComponent } from './takequiz/takequiz.component';
import { ReviewComponent } from './review/review.component';
import { ResultsComponent } from './results/results.component';
import { SubmitquizComponent } from './submitquiz/submitquiz.component';
import {FormsModule} from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';
import { QuizService } from './quiz.service';
import { ProfileComponent } from './profile/profile.component';
import { LoginComponent } from './login/login.component';
import { SavingComponent } from './saving/saving.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    TakequizComponent,
    ReviewComponent,
    ResultsComponent,
    SubmitquizComponent,
    ProfileComponent,
    SavingComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [QuizService],
  bootstrap: [AppComponent]
})
export class AppModule { }
