import { Component, OnInit,Input,OnChanges,SimpleChange } from '@angular/core';

import { Recipe } from './hero';
import { HeroesService } from './heroes.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  providers: [ HeroesService ],
  styleUrls: ['./heroes.component.css']
})


export class HeroesComponent implements OnChanges {
  recipe:Recipe;
  @Input() recipeSelected;
  constructor(private heroesService: HeroesService) { }

  
  
  ngOnChanges(changes: {[propKey: string]: SimpleChange}) {
    for (let propName in changes) {
      let changedProp = changes[propName];
      let recipeId = JSON.stringify(changedProp.currentValue);
      if(recipeId){
        this.heroesService.getSingleRecipe(recipeId).subscribe(recipe => this.recipe = recipe );
      }  
    }
  }
}
