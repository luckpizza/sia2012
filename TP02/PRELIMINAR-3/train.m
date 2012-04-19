function [ newWeights ] = train( activationFunctions, activationFunctionsDeriv, allWeights, inputs, expectedOutputs, eta )

%TRAIN Trains the network
%   activationFunctions the functions for each level - cell type
%   activationFunctionsDeriv the derivs for the functions - cell type
%   allWeights the weights for each level in a matrix - cell type
%   inputs n patterns

    levelQty = length(activationFunctions);
    outputLen = length(expectedOutputs(1, :));
    
    newWeights = allWeights;
    
    indexes = randperm(length(inputs(:,1)));
    
    oldAltoDelta = cell(levelQty,1);
    altoDelta = cell(levelQty,1);
    
    for i = 1:levelQty
        oldAltoDelta{i} = zeros(size(newWeights{i}));
    end
    
    for i = 1:length(indexes)
        % Hace esta primera pasada para la entrada, porque el V^{m-1} es la entrada.
        output = calculateOutput(activationFunctions, newWeights, inputs(indexes(i), :));
        output = {inputs(indexes(i), :), output{:}};
        deltas = cell(levelQty,1);
        deltas{levelQty} = zeros(length(newWeights{levelQty}(:,1))-1, 1);
        
        % Calcular los pesos para las siguientes capas.
        for j=2:length(outputLen)+1
            deriv = calculate( activationFunctionsDeriv{levelQty}, newWeights{levelQty}(j-1, :), output{levelQty} );
            deltas{levelQty}(j-1) = ((expectedOutputs(indexes(i), j-1)-output{levelQty+1}(j))*deriv);
        end


        %Comienza la correción con backpropagation.
        % Tener en cuenta que utiliza kp donde toma la matriz de pesos
        % desde arriba hacia abajo. En este for se calculan los deltas.
        for k = 1:(levelQty-1)
            kp = levelQty-k;
            deltas{kp} = zeros(length(newWeights{kp+1}(1,:))-1, 1);
            for j=2:length(newWeights{kp+1}(1, :))
                deriv = calculate( activationFunctionsDeriv{kp}, newWeights{kp}(j-1, :), output{kp} );
                sum = newWeights{kp+1}(:,j)'*deltas{kp+1};
                deltas{kp}(j-1) = (sum*deriv);
            end
        end
        
        % Se actualizan los pesos.
        for j=1:levelQty
            altoDelta{j} = deltas{j}*eta*output{j};
            newWeights{j} = newWeights{j} + altoDelta{j}; 
            oldAltoDelta{j} = altoDelta{j};
        end
    end 

end

