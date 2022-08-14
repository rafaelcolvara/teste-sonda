package br.com.elo7.sonda.candidato.model;

public enum Direction implements DirectionInterface {
    N {
        @Override
        public Direction turnLeft(){
            return Direction.W;
        }
        @Override
        public Direction turnRight() {
            return Direction.E;
        }

    },
    E {
        @Override
        public Direction turnLeft(){
            return Direction.N;
        }
        @Override
        public Direction turnRight() {
            return Direction.S;
        }
    },
    S{
        @Override
        public Direction turnLeft(){
            return Direction.E;
        }
        @Override
        public Direction turnRight() {
            return Direction.W;
        }
    },
    W{
        @Override
        public Direction turnLeft(){
            return Direction.S;
        }
        @Override
        public Direction turnRight() {
            return Direction.N;
        }
    };

    Direction() {

    }


}
