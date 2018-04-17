import { Component,OnInit, Output,EventEmitter } from '@angular/core';
import { Config, ConfigService } from './config.service';
import { MessageService } from '../message.service';
import { Recipe } from '../heroes/hero';
import { Ingredient } from '../heroes/ingredient';
import { HeroesService } from '../heroes/heroes.service';

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styles: ['.error {color: red;}']
})
export class ConfigComponent implements OnInit {
  error: any;
  headers: string[];
  config: Config;
  recipe:Recipe;
  recipes:any;
  ingredient:Ingredient;
  noRecipe = false;
  ingredientValidation = false;
  @Output() showAddRecipe = new EventEmitter<boolean>();
  showRecipe = false;

  ngOnInit() {
    this.noRecipe=false;
    this.ingredientValidation = false;
  }
 constructor(private heroesService: HeroesService) { }

  addRecipe(recipeObj){
    var recipe:Recipe = {
      "name":"",
      "incredients":[]
    };
    var recipes:any;
    var ingredient:Ingredient = {
      "name":""
    };

    recipe.name = recipeObj.recipe.value;
    if(!recipe.name)
    {
      this.noRecipe = true;
    }else{
      this.noRecipe = false;
    }
    if(recipeObj.ingredient1.value){
      recipe.incredients.push({"name":recipeObj.ingredient1.value});
    }
    if(recipeObj.ingredient2.value){
      recipe.incredients.push({"name":recipeObj.ingredient2.value});
    }if(recipeObj.ingredient3.value){
      recipe.incredients.push({"name":recipeObj.ingredient3.value});
    }if(recipeObj.ingredient4.value){
      recipe.incredients.push({"name":recipeObj.ingredient4.value});
    }
    if(recipe && recipe.incredients.length != 0){
      this.ingredientValidation = false;
      this.heroesService.addReceipe(recipe)
      .subscribe(recipes => this.showAddRecipe.emit(this.showRecipe));
    }else if(recipe.incredients.length == 0){
        this.ingredientValidation = true;
    }

  }
  close(){
    this.showRecipe = false;
    this.showAddRecipe.emit(this.showRecipe);
  }
}
