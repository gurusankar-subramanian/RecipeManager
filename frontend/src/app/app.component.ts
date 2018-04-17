import { Component} from '@angular/core';
import { Recipe } from './heroes/hero';
import { HeroesService } from './heroes/heroes.service'; 

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  showHeroes = true;
  showAddRecipe = false;
  showDownloader = true;
  showUploader = true;
  showSearch = true;
  recipeList :Recipe[];
  recipeSelected ;
  constructor(private heroesService: HeroesService) { }
  
    ngOnInit() {
      this.getHeroes();
    }
  
    getHeroes(): void {
      this.heroesService.getreceipe()
        .subscribe(
          recipeList => this.recipeList = recipeList
        ) ;
    }

  toggleHeroes() { this.showHeroes = !this.showHeroes; }

  add(){this.showAddRecipe = true;this.showHeroes = false;}

  showRecipe(flag: boolean){
    this.showAddRecipe = flag; 
    this.showHeroes = !this.showHeroes;
    this.getHeroes();
  }

  selectedRecipe(id){
    this.recipeSelected = id;
  }


 }
